module Client where

import Data.List
import Extras
import System.IO

data Client = Client
  { idClient :: Integer,
    nameClient :: String,
    cnhClient :: String
  }
  deriving (Show)

clientCreator :: Integer -> String -> String -> Client
clientCreator i x z =
  Client
    { idClient = i,
      nameClient = x,
      cnhClient = z
    }

readClient :: IO Client
readClient = do
  putStr "Informe o Id: "
  ridClient <- promptInteger ""
  putStr "Informe o nome: "
  rnameClient <- getLine
  putStr "Informe a CNH: "
  rcnhClient <- getLine
  return $ Client ridClient rnameClient rcnhClient
