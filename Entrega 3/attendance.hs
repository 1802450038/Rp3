module Attendance where

import Banco
import Client
import Data.List
import Database.HDBC
import Database.HDBC.PostgreSQL
import Extras
import System.IO

registerClient :: IO ()
registerClient = do
  connection <- connectConn
  client <- readClient
  insertClient client connection
  disconnectConn connection
  putStrLn "Cliente inserido com sucesso"

consultClient :: Integer -> IO ()
consultClient id = do
  connection <- connectConn
  client <- retriveClientId connection id
  mapM_ print client
  disconnectConn connection

listClients :: IO ()
listClients = do
  connection <- connectConn
  clients <- retriveClients connection
  mapM_ print clients
  disconnectConn connection

alterClient :: IO ()
alterClient = do
  listClients
  putStrLn "Informe o id do cliente que deseja atualizar"
  connection <- connectConn
  client <- readClient
  updateClient client connection
  disconnectConn connection
  putStrLn "Cliente atualizado com sucesso para:"
  let id = idClient client
  consultClient id
  disconnectConn connection

deleteClient :: IO ()
deleteClient = do
  putStrLn "Informe o id do cliente que deseja remover"
  id <- promptInteger ""
  connection <- connectConn
  removeClient connection id
  disconnectConn connection
  putStrLn "Cliente removido com sucesso"

searchClient :: IO ()
searchClient = do
  putStrLn "Busca de cliente"
  putStrLn "[1] - Buscar por ID"
  putStrLn "[2] - Buscar por Nome"
  putStrLn "[3] - Sair"
  putStrLn "Selecione uma opcao"
  hFlush stdout
  c <- getLine
  case c of
    "1" -> do
      putStrLn "Informe o id:"
      id <- promptInteger ""
      connection <- connectConn
      client <- retriveClientId connection id
      mapM_ print client
    "2" -> do
      putStrLn "Informe o nome:"
      name <- getLine
      connection <- connectConn
      client <- retriveClientName connection name
      mapM_ print client
    "3" -> do
      putStrLn "Até mais"
      return ()

-- Vehicle

registerVehicle :: IO ()
registerVehicle = do
  connection <- connectConn
  vehicle <- readVehicle
  insertVehicle vehicle connection
  disconnectConn connection
  putStrLn "Veiculo inserido com sucesso"

consultVehicle :: Integer -> IO ()
consultVehicle id = do
  connection <- connectConn
  vehicle <- retriveVehicleId connection id
  mapM_ print vehicle
  disconnectConn connection

listVehicles :: IO ()
listVehicles = do
  connection <- connectConn
  vehicles <- retriveVEhicles connection
  mapM_ print vehicles
  disconnectConn connection

alterVehicle :: IO ()
alterVehicle = do
  listVehicles
  putStrLn "Informe o id do veiculo que deseja atualizar"
  connection <- connectConn
  vehicle <- readVehicle
  updateClient vehicle connection
  disconnectConn connection
  putStrLn "Veiculo atualizado com sucesso para:"
  let id = idVehicle vehicle
  consultVehicle id
  disconnectConn connection

deleteVehicle :: IO ()
deleteVehicle = do
  putStrLn "Informe o id do Veiculo que deseja remover"
  id <- promptInteger ""
  connection <- connectConn
  removeVehicle connection id
  disconnectConn connection
  putStrLn "Veiculo removido com sucesso"

searchVehicle :: IO ()
searchVehicle = do
  putStrLn "Busca de veiculo"
  putStrLn "[1] - Buscar por ID"
  putStrLn "[2] - Buscar por Placa"
  putStrLn "[3] - Sair"
  putStrLn "Selecione uma opcao"
  hFlush stdout
  c <- getLine
  case c of
    "1" -> do
      putStrLn "Informe o id:"
      id <- promptInteger ""
      connection <- connectConn
      vehicle <- retriveVehicleId connection id
      mapM_ print vehicle
    "2" -> do
      putStrLn "Informe a placa:"
      plate <- getLine
      connection <- connectConn
      vehicle <- retriveVehiclePlate connection plate
      mapM_ print vehicle
    "3" -> do
      putStrLn "Até mais"
      return ()

-- Rent
registerRent :: IO ()
registerRent = do
  connection <- connectConn
  rent <- readRent
  insertRent rent connection
  disconnectConn connection
  putStrLn "Aluguel registrado com sucesso"

consultRent :: Integer -> IO ()
consultRent id = do
  connection <- connectConn
  rent <- retriveRentId connection id
  mapM_ print rent
  disconnectConn connection

listRents :: IO ()
listRents = do
  connection <- connectConn
  rents <- retriveRents connection
  mapM_ print rents
  disconnectConn connection

finalizeRent :: IO ()
finalizeRent = do
  putStrLn "Informe o id do aluguel que deseja remover"
  id <- promptInteger ""
  connection <- connectConn
  removeRent connection id
  disconnectConn connection
  putStrLn "Aluguel finalizado com sucesso"

searchRent :: IO ()
searchRent = do
  putStrLn "Busca de Aluguel"
  putStrLn "[1] - Buscar por ID"
  putStrLn "[2] - Buscar por Nome do Cliente"
  putStrLn "[3] - Buscar por Placa Veiculo"
  putStrLn "[4] - Sair"
  putStrLn "Selecione uma opcao"
  hFlush stdout
  c <- getLine
  case c of
    "1" -> do
      putStrLn "Informe o id:"
      id <- promptInteger ""
      connection <- connectConn
      rent <- retriveRentId connection id
      mapM_ print rent
    "2" -> do
      putStrLn "Informe o nome:"
      name <- getLine
      connection <- connectConn
      rent <- retriveRentName connection name
      mapM_ print rent
    "3" -> do
      putStrLn "Informe a placa:"
      plate <- getLine
      connection <- connectConn
      rent <- retriveRentPlate connection plate
      mapM_ print rent
    "4" -> do
      putStrLn "Até mais"
      return ()

-- 1- Como Atendente eu quero manter (incluir, alterar, excluir e consultar)
-- os cadastros básicos do programa.

-- 2- Como Atendente eu quero registrar a retirada de um carro por um Cliente informando:
-- Nome, CNH, Categoria do Veículo, Placa do Veículo, Quilometragem do Veículo e Data da Retirada.

-- 3- Como Atendente eu quero registrar a devolução de um carro por um Cliente informando:
--  Placa do Veículo, Quilometragem do Veículo e Data da Devolução.

-- 4- Como Atendente eu quero calcular o valor da locação somando as diárias
-- (número de dias * valor da diária da categoria) com a quilometragem (Quilometragem excedente

-- * valor do quilômetro da categoria).

-- 5- Como Atendente eu quero incrementar a pontuação do cliente no programa de fidelidade
--  na proporção de 1 ponto para cada 100 quilômetros rodados.

-- 6- Como Atendente eu quero resgatar pontos do programa de fidelidade
--  na forma de desconto para o Cliente na proporção de 1% para cada 100 pontos acumulados.

-- 7- Como Atendente eu quero verificar os carros disponíveis para aluguel
--  por categoria, de acordo com os pontos do programa de fidelidade de um Cliente.

-- 8- Como Atendente eu quero gerar um relatório com informações atualizadas
--  sobre os veículos, informando veículos disponíveis, veículos alugados e veículos em manutenção.