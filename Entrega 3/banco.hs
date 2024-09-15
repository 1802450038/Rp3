{-# LANGUAGE BlockArguments #-}

module Banco where

import Client
import Control.Exception
import Control.Monad
import Database.HDBC
import Database.HDBC.PostgreSQL
import Person
import Rent
import System.IO
import Vehicle

-- Create a Conn



connectConn :: IO Connection
connectConn = do
  connectPostgreSQL "host=localhost dbname=locadora user=postgres password=123"

disconnectConn :: IConnection c => c -> IO ()
disconnectConn conn = do
  disconnect conn

insertClient :: IConnection c => Client -> c -> IO ()
insertClient client conn = do
  run
    conn
    "INSERT INTO tb_client VALUES (?,?,?)"
    [ toSql $ idClient client,
      toSql $ nameClient client,
      toSql $ cnhClient client
    ]
  commit conn

--  Client Update Client (Atualizar)

updateClient :: IConnection c => Client -> c -> IO ()
updateClient client conn = do
  run
    conn
    "UPDATE tb_client SET c_id = ?, c_name = ?, c_cnh = ? WHERE c_id = ?"
    [ toSql $ idClient client,
      toSql $ nameClient client,
      toSql $ cnhClient client,
      toSql $ idClient client
    ]
  commit conn

-- Client Retrive (Recuperar)

retriveClients :: IConnection c => c -> IO [Client]
retriveClients conn = do
  let sql = "SELECT c_id, c_name, c_cnh FROM tb_client"
  rows <- quickQuery conn sql []
  return $ map clientConvrow rows

--  Client Retrive By Id (Recuperar por ID)

retriveClientId :: IConnection c => c -> Integer -> IO [Client]
retriveClientId conn wantedid = do
  res <-
    quickQuery
      conn
      "SELECT c_id, c_name, c_cnh FROM tb_client WHERE c_id = ? ORDER BY c_id"
      [toSql wantedid]
  return $ map clientConvrow res

retriveClientName :: IConnection c => c -> String -> IO [Client]
retriveClientName conn wantedname = do
  res <-
    quickQuery
      conn
      "SELECT c_id, c_name, c_cnh FROM tb_client WHERE c_name = ? ORDER BY c_id"
      [toSql wantedname]
  return $ map clientConvrow res

retriveClientCnh :: IConnection c => c -> String -> IO [Client]
retriveClientCnh conn wantedCnh = do
  res <-
    quickQuery
      conn
      "SELECT c_id, c_name, c_cnh FROM tb_client WHERE c_cnh = ? ORDER BY c_id"
      [toSql wantedCnh]
  return $ map clientConvrow res

--  Client Delete By Id (Deletar por Id)

removeClient :: IConnection c => c -> Integer -> IO ()
removeClient conn wantedid = do
  run
    conn
    "DELETE FROM tb_client WHERE c_id = ?"
    [toSql wantedid]
  commit conn

-- Parses Client from SQL (converte os dados do banco para HASKELL)
clientConvrow :: [SqlValue] -> Client
clientConvrow [cid, cname, ccnh] =
  Client
    { idClient = fromSql cid,
      nameClient = fromSql cname,
      cnhClient = fromSql ccnh
    }

-- Rent



insertRent :: IConnection c => Rent -> c -> IO ()
insertRent rent conn = do
  run
    conn
    "INSERT INTO tb_rent VALUES (?,?,?,?,?,?,?)"
    [ toSql $ rentId rent,
      toSql $ cliName rent,
      toSql $ cliCNH rent,
      toSql $ vehCat rent,
      toSql $ vehPla rent,
      toSql $ dateOfWithdrawal rent,
      toSql $ km rent
    ]
  commit conn

--  Client Update Client (Atualizar)

updateRent :: IConnection c => Rent -> c -> IO ()
updateRent rent conn = do
  run
    conn
    "UPDATE tb_rent SET r_id = ?, r_cname = ?, r_ccnh = ?, r_vcat = ?, r_vpla = ?, r_date ?, r_km WHERE r_id = ?"
    [ toSql $ rentId rent,
      toSql $ cliName rent,
      toSql $ cliCNH rent,
      toSql $ vehCat rent,
      toSql $ vehPla rent,
      toSql $ dateOfWithdrawal rent,
      toSql $ km rent
    ]
  commit conn

-- Client Retrive (Recuperar)

retriveRents :: IConnection c => c -> IO [Rent]
retriveRents conn = do
  let sql = "SELECT r_id, r_cname, r_ccnh, r_vcat, r_vpla, r_date, r_km FROM tb_rent"
  rows <- quickQuery conn sql []
  return $ map rentConvrow rows

--  Client Retrive By Id (Recuperar por ID)

retriveRentId :: IConnection c => c -> Integer -> IO [Rent]
retriveRentId conn wantedid = do
  res <-
    quickQuery
      conn
      "SELECT r_id, r_cname, r_ccnh, r_vcat, r_vpla, r_date, r_km WHERE r_id = ? ORDER BY r_id"
      [toSql wantedid]
  return $ map clientConvrow res

retriveRentName :: IConnection c => c -> String -> IO [Rent]
retriveClientName conn wantedname = do
  res <-
    quickQuery
      conn
      "SELECT r_id, r_cname, r_ccnh, r_vcat, r_vpla, r_date, r_km WHERE r_cname = ? ORDER BY r_id"
      [toSql wantedname]
  return $ map clientConvrow res

retriveRentPlate :: IConnection c => c -> String -> IO [Rent]
retriveClientName conn wantedname = do
  res <-
    quickQuery
      conn
      "SELECT r_id, r_cname, r_ccnh, r_vcat, r_vpla, r_date, r_km WHERE r_vpla = ? ORDER BY r_id"
      [toSql wantedname]
  return $ map clientConvrow res

removeRent :: IConnection c => c -> Integer -> IO ()
removeRent conn wantedid = do
  run
    conn
    "DELETE FROM tb_rent WHERE r_id = ?"
    [toSql wantedid]
  commit conn

-- Parses Vehicle from SQL (converte os dados do banco para HASKELL)
rentConvrow :: [SqlValue] -> Rent
rentConvrow [rid, rcname, rccnh, rvcat, rvpla, rdate, rkm] =
  Rent
    { rentId = fromSql rid,
    cliName = fromSql rcname,
    cliCNH = fromSql ,
    vehCat = rvcat,
    vehPla = rvpla,
    dateOfWithdrawal = rdate,
    km = rkm
    }

--Vehicle 
  let sql = "SELECT v_id, v_category, v_vehicleStatus, v_plateNumber, v_kmTraveled, v_value FROM tb_Vehicle"
  rows <- quickQuery conn sql []
  return $ map VehicleConvrow rows

--  Vehicle Retrive By Id (Recuperar por ID)

retriveVehicleIdV:: IConnection c => c -> Integer -> IO [Vehicle]
retriveVehicleId Cat = do
  res <-
sS    quickQueryvehPla      conn
tTTr      "SELECT v_id, v_category, v_vehicleStatus, v_plateNumber, v_kmTraveled, v_value WHERE v_id = ? ORDER BY v_id"
      [toSql wantedid]
  return $ map VehicleConvrow res

retriveVehiclePlate :: IConnection c => c -> String -> IO [Vehicle]
retriveVehicleName conn wantedplate = do
  res <-
    quickQuery
      conn
      "SELECT v_id, v_category, v_vehicleStatus, v_plateNumber, v_kmTraveled, v_value WHERE v_plateNumber = ? ORDER BY v_id"
      [toSql wantedplate]
  return $ map VehicleConvrow res

retriveVehicleStatus :: IConnection c => c -> String -> IO [Vehicle]
retriveVehicleCnh conn wantedStatus = do
  res <-
    quickQuery
      conn
      "SELECT v_id, v_category, v_vehicleStatus, v_plateNumber, v_kmTraveled, v_value FROM tb_Vehicle WHERE v_vehicleStatus = ? ORDER BY v_id"
      [toSql wantedStatus]
  return $ map VehicleConvrow res

--  Vehicle Delete By Id (Deletar por Id)

removeVehicle :: IConnection c => c -> Integer -> IO ()
removeVehicle conn wantedid = do
  run
    conn
    "DELETE FROM tb_Vehicle WHERE v_id = ?"
    [toSql wantedid]
  commit conn

vehicleId :: Integer,
    vehicleCategory :: String,
    plateNumber :: String,
    kmTraveled :: Integer,
    value :: Integer,
    vehicleStatus :: String 

-- Parses Vehicle from SQL (converte os dados do banco para HASKELL)
VehicleConvrow :: [SqlValue] -> Vehicle
VehicleConvrow [vid, vcategory, vvehicleStatus, vplatenumber, vkmtraveled, vvalue] =
  Vehicle
    { idVehicle = fromSql cid,
      vehicleCategory = fromSql vcategory,
      vehicleStatus = fromSql vvehicleStatus,
      value = fromSql vvalue,
      kmTraveled = fromSql vkmtraveled,
      plateNumer = fromSql vplatenumber
    }  rows <- quickQuery conn sql []
  return $ map VehicleConvrow rows

--  Vehicle Retrive By Id (Recuperar por ID)

retriveVehicleId :: IConnection c => c -> Integer -> IO [Vehicle]
retriveVehicleId conn wantedid = do
  res <-
    quickQuery
      conn
      "SELECT v_id, v_category, v_vehicleStatus, v_plateNumber, v_kmTraveled, v_value WHERE v_id = ? ORDER BY v_id"
      [toSql wantedid]
  return $ map VehicleConvrow res

retriveVehiclePlate :: IConnection c => c -> String -> IO [Vehicle]
retriveVehicleName conn wantedplate = do
  res <-
    quickQuerdStatus = do
  res <-
    quickQuery
v     conn
v     "SELECT v_id, v_category, v_vehicleStatus, v_plateNumber, v_kmTraveled, v_value FROM tb_Vehicle WHERE v_vehicleStatus = ? ORDER BY v_id"
      [toSql wantedStatus]
  return $ map VehicleConvrow res

--  Vehicle Delete By Id (Deletar por Id)

removeVehicle :: IConnection c => c -> Integer -> IO ()
removeVehicle conn wantedid = do
  run
    conn
    "DELETE FROM tb_Vehicle WHERE v_id = ?"
    [toSql wantedid]
  commit conn

vehicleId :: Integer,
    vehicleCategory :: String,
    plateNumber :: String,
    kmTraveled :: Integer,
    value :: Integer,
    vehicleStatus :: String 

-- Parses Vehicle from SQL (converte os dados do banco para HASKELL)
VehicleConvrow :: [SqlValue] -> Vehicle
VehicleConvrow [vid, vcategory, vvehicleStatus, vplatenumber, vkmtraveled, vvalue] =
      [toSql wantedStatus]
  return $ map VehicleConvrow res

--  Vehicle Delete By Id (Deletar por Id)

removeVehicle :: IConnection c => c -> Integer -> IO ()
removeVehicle conn wantedid = do
  run
    conn
    "DELETE FROM tb_Vehicle WHERE v_id = ?"
    [toSql wantedid]
  commit conn

vehicleId :: Integer,
    vehicleCategory :: String,
    plateNumber :: String,
    kmTraveled :: Integer,
    value :: Integer,
    vehicleStatus :: String 

-- Parses Vehicle from SQL (converte os dados do banco para HASKELL)
VehicleConvrow :: [SqlValue] -> Vehicle
VehicleConvrow [vid, vcategory, vvehicleStatus, vplatenumber, vkmtraveled, vvalue] =
  Vehicle
    { idVehicle = fromSql cid,
      vehicleCategory = fromSql vcategory,
      vehicleStatus = fromSql vvehicleStatus,
      value = fromSql vvalue,
      kmTraveled = fromSql vkmtraveled,
      plateNumer = fromSql vplatenumber
    }