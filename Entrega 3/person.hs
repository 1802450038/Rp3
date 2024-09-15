module Person where

import Extras
import System.IO

data Person = Person
  { personId :: Integer,
    personName :: String,
    age :: Integer,
    cpf :: String
  }
  deriving (Eq, Ord, Show, Read)

staticPerson :: Person
staticPerson =
  Person
    { personId = 0,
      personName = "Dougras",
      age = 26,
      cpf = "123456"
    }

readPerson :: IO Person
readPerson = do
  putStrLn "Insira o Id: "
  rpersonId <- promptInteger ""
  putStrLn "Insira o Nome: "
  rpersonName <- getLine
  putStrLn "Insira a Idade: "
  rage <- promptInteger ""
  putStrLn "Insira o CPF: "
  rcpf <- getLine
  return $ Person rpersonId rpersonName rage rcpf

personToString :: Person -> String
personToString (Person {personName = r, age = n, cpf = q}) = show r
