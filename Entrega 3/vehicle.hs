module Vehicle where

import Data.List
import Extras
import System.IO

data Vehicle = Vehicle
  { vehicleId :: Integer,
    vehicleCategory :: String,
    plateNumber :: String,
    kmTraveled :: Integer,
    value :: Integer,
    vehicleStatus :: String
  }
  deriving (Eq, Ord, Show, Read)

readVehicle :: IO Vehicle
readVehicle = do
  putStr "Informe o Id: "
  ridVehicle <- promptInteger ""
  putStr "Informe a Categoria: "
  rcatVehicle <- getLine
  putStr "Informe a placa: "
  rplateVehicle <- getLine
  putStr "Informe a quilometragem: "
  rkmVehicle <- promptInteger ""
  putStr "Informe o Valor: "
  rvalueVehicle <- promptInteger ""
  putStr "Informe a disponibilidade:0 [Disponivel] [Manutencao] [Alugado]"
  rstatusVehicle <- getLine
  return $ Vehicle ridVehicle rcatVehicle rplateVehicle rkmVehicle rvalueVehicle rstatusVehicle


  