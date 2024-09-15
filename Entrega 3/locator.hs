module Locator where
import Extras
data Locator = Locator {
    locatorName :: String,
    address :: String,
}
 deriving (Eq, Ord, Show, Read)

staticLocator :: Locator
staticLocator =
  Locator
    { locatorName = "Carros Usados",
      address = "rua 0",
    }

readLocator :: IO Locator
readLocator = do
  rlocatorName <- promptString "Nome "
  raddress <- promptString "Endereco "
  return $ Locator rlocatorName raddress


locatorToString :: Locator -> String
locatorToString (Locator {locatorName = r, address = n}) = show r n

infoLocator :: Locator -> String
infoLocator locator = (locatorName locator) ++ " " ++ (address locator)



