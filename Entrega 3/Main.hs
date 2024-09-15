module Main where
import Extras
import Attendance
import Banco
import Client
import Database.HDBC
import Database.HDBC.PostgreSQL
import Person
import System.IO
import Vehicle




main :: IO ()
main = do
  option <- menu
  case option of
    Insert -> registerClient
    Alter -> alterClient
    Delete -> deleteClient
    Search -> searchClient
    List   -> listClients
    Quit -> do
      putStrLn "Ate mais"
      return()
  -- putStrLn "Bem vindo ao sistema"
  -- conn <- connectConn
  -- client <- readClient
  -- insertClient client conn
  -- disconnectConn conn

  -- putStrLn "Haskell é ruim"

-- HDBC

-- conn <- connectPostgreSQL "host=localhost dbname=locadora user=postgres password=123"

-- Person
-- person <- readPerson
-- updatePerson person conn
-- insertPerson person conn
-- putStrLn "Pessoa inserida com sucesso"
-- persons <- retrivePersons conn
-- mapM_ print persons
-- removePerson conn 2
-- persons <- retrivePersons conn
-- mapM_ print persons
-- person2 <- retrivePerson conn 3
-- print person2

-- Vehicle
-- let vehicle = staticVehicle
-- updateVehicle vehicle conn
-- insertVehicle staticVehicle conn
-- removeVehicle conn 1
--veiculos <- retriveVehicles conn
--print veiculos
--veiculo <- retriveVehicle conn 1
--print veiculo

-- Client
-- let client = clientCreator 2 "Alisson" 23 123456
-- updateClient client conn
-- insertClient client conn
-- removeClient conn 1
-- clients <- retriveClients conn
-- print clients
-- veiculo <- retriveClient conn 2
-- print veiculo

-- HDBC
-- disconnect conn
