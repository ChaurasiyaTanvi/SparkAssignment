package SparkAssignment

import org.apache.spark.sql.DataFrame

object SparkJoinBasedAssignment {
  /*Write a query to output the names of those students whose best friends got offered a higher salary than them.
  Names must be ordered by the salary amount offered to the best friends. It is guaranteed that no two students got same salary offer*/

  def main(args: Array[String]): Unit = {
    //Spark Session
    val spark = SparkSession.builder().appName("Assignment").getOrCreate()

    //Initializing the student,friend,packages dataframe
    val student = Seq((1,"John"),(2,"Auther"),(3,"Rakesh"),(4,"Shreya")).toDF("ID","Name")
    val friend = Seq((1,2),(2,3),(3,4),(4,1)).toDF("ID","Friend_ID")
    val packages = Seq((1,15.20),(2,10.06),(3,11.55),(4,12.12)).toDF("ID","Salary")
    //Stroing into temp table
    student.createOrReplaceTempView("student")
    friend.createOrReplaceTempView("friend")
    packages.createOrReplaceTempView("packages")

    val finalDF = spark.sql("SELECT s.Name FROM student s INNER JOIN packages p ON s.ID = p.ID LEFT JOIN friend f ON f.ID = s.ID LEFT JOIN packages p2 ON f.Friend_ID = p2.ID WHERE p.Salary <= p2.Salary ORDER BY p2.Salary")
    println("Students whose best friend got higher salary offers:")
    finalDF.show
  }
}
