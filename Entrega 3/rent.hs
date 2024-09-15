module Rent where
-- import Banco
import Client
import Data.List
import Date
import Extras
import System.IO
import Vehicle

data Rent = Rent
  { rentId :: Integer,
    cliName :: String,
    cliCNH :: String,
    vehCat :: String,
    vehPla :: String,
    dateOfWithdrawal :: Date,
    km :: Integer
  }
  deriving (Show)

readRent :: IO Rent
readRent = do
  putStrLn "Informe o id do aluguel"
  rentId <- promptInteger ""
  putStrLn "Informe o nome do cliente"
  cliName <- getLine
  putStrLn "Informe a CNH do cliente"
  cliCNH <- getLine
  putStrLn "Informe a categoria do veiculo"
  vehCat <- getLine
  putStrLn "Informe a placa do veiculo"
  vehPla <- getLine
  putStrLn "Informe a kilometragem"
  km <- promptInteger ""
  putStrLn "Informe o dia de hoje"
  day <- promptInteger ""
  putStrLn "Informe o mes atual"
  month <- promptInteger ""
  putStrLn "Informe o ano atual"
  year <- promptInteger ""
  putStrLn  "Informe o ano"
  let dateOfWithdrawal = dateFactory day month year
  return $ Rent rentId cliName cliCNH vehCat vehPla dateOfWithdrawal km

valueOfRent :: Float -> Float -> Vehicle -> Float
valueOfRent days value vec = do
  let cat = vehicleCategory vec
  let km = kmTraveled vec
  let floatKm = fromInteger km :: Float
  if cat == "Esportivo"
    then days * (value * 1.15) + (floatKm * 1.15)
    else
      if cat == "SUV"
        then days * (value * 1.1) + (floatKm * 1.1)
        else
          if cat == "Utilitario"
            then days * (value * 1.2) + (floatKm * 1.2)
            else
              if cat == "Seda"
                then days * (value * 1.1) + (floatKm * 1.1)
                else
                  if cat == "Hatch"
                    then days * (value * 1.05) + (floatKm * 1.05)
                    else value * days + (floatKm * 1.0)

