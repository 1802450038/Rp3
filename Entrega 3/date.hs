module Date where
import Data.List
import System.IO

data Date = 
    Date  {
        day :: Integer,
        month :: Integer,
        year :: Integer 
    }
    deriving (Show)

formatDate :: Date -> String 
formatDate date = 
    if day date < 30 && day date > 0 && month date > 0 && month date <= 12
        then show (day date) ++ "/" ++ show (month date) ++ "/" ++ show (year date)
    else "invalid date"

dateFactory :: Integer -> Integer -> Integer -> Date 
dateFactory d m y = do 
    dateCreator $ Date {day = d, month = m, year = y}
   
dateCreator :: Date -> Date
dateCreator date 
            | day date > 30 = Date {day = 30, month = month date, year = year date}
            | day date < 1 =  Date { day = 1, month = month date, year = year date }
            | month date < 1 = Date {day = day date, month = 1,year = year date }    
            | month date > 12 = Date {day = 30,month = 12,year = year date}
            | otherwise = Date{day = day date, month = month date, year = year date}    

staticDate :: Date
staticDate = 
    Date {
        day = -1, 
        month = 10,
        year = 1999
}