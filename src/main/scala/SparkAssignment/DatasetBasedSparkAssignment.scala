package SparkAssignment

object DatasetBasedSparkAssignment {
  def main(args: Array[String]): Unit = {
    //Spark Session
    val spark = SparkSession.builder().appName("Assignment").getOrCreate()

    //Data Insertion for data.csv
    val data = spark.read.format("csv").option("header", "true").load("Assignment_data/dataset.csv")

    println("Extract the data for the state name that begins with A")
    val que1 = data.filter(col("state").startsWith("A"))
    que1.show

    println("compute amount in brief number of no2 on the particular date")
    val que2 = data.groupBy("date").agg(sum("no2").as("Sum"))
    que2.show

    println("sample the data with date column containing the year value 2008")
    val que3 = data.filter(col("date").contains("2018"))
    que3.show

    println("Compute number of null records in the column pm25")
    val que4 = data.filter(col("pm2_5").isNull).count
    print(que4)

    println("Write only top ten records of the file to another file")
    val que5 = data.limit(10).write.csv("Assignment_data/top10File")
    que5.show

    println("Display the descriptive statistics of the column so2")
    val que6 = data.describe("so2")
    que6.show

    println("Extract the records where station codes are even")
    val que7 = data.filter((col("stn_code") % 2) === 0)
    que7.show

    //Data Insertion for brewries_us.csv
    val brewData = spark.read.format("csv").option("header", true).option("inferSchema", true).load("Assignment_data/breweries_us.csv")

    println("Compute number of Microbrewery in the  states of USA")
    val que8 = brewData.filter((col("state").equalTo("USA")) && (col("type").equalTo("Microbrewery"))).count
    que8.show

    println("Extract the records containing orggis.com  in the url")
    val que10 = brewData.filter(col("website").contains("orggis.com"))
    que10.show

    println("Compute distinct number of  states in the given dataset")
    val que12 = brewData.select("state").distinct.count
    que12.show

    println("Compute the number of records with url not available for them")
    val que13 = brewData.filter(col("website").isNull).count
    que13.show

    //The dataframe contains one column containing Array, store this dataframe into csv file
    println("|origin|destination|internal_flight_ids|-------> Perform suitable spark operation so that it can be written into csv file")
    val last_que = data.withColumn("internal_flight_ids", lit("internal_flight_ids").cast("string")).write.csv(path = "Assignment_data/writeLastQue")
  }
}
