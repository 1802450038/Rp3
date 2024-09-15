module Extras where

import System.IO

promptString :: String -> IO String
promptString promptStr = do
  putStr $ promptStr <> ": "
  hFlush stdout
  line <- getLine
  return line

promptInteger :: String -> IO Integer
promptInteger promptInt = do
  putStr $ promptInt <> ": "
  hFlush stdout
  line <- getLine
  return $ read line

promptFloat :: String -> IO Float
promptFloat promptFl = do
  putStr $ promptFl <> ": "
  hFlush stdout
  line <- getLine
  return $ read line



data MenuOption
  = Insert
  | Alter
  | Delete
  | Search
  | List
  | Quit

menu :: IO MenuOption
menu = do
  putStrLn "Bem vindo a Locadora"
  putStrLn "[1] - Cadastrar cliente"
  putStrLn "[2] - Atualizar cliente"
  putStrLn "[3] - Remover Cliente"
  putStrLn "[4] - Buscar Cliente"
  putStrLn "[5] - Listar Clientes"
  putStrLn "Selecione uma opcao: "
  hFlush stdout
  c <- getLine
  case c of
    "1" -> return Insert
    "2" -> return Alter
    "3" -> return Delete 
    "4" -> return Search 
    "5" -> return List
    _ -> return Quit
  
  
  
  

