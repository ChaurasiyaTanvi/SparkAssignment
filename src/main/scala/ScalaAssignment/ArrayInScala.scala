package ScalaAssignment

//What is array in scala ? Can you write code to fetch array ,fetch 2nd element of array,add all array elements
/* Array is fixed size data structure which stores same type of data. In scala, arrays are generic i.e. we can have type parameter or abstract parameter and also array
 are compatible with sequence. */
object ArrayInScala {
  def main(args: Array[String]): Unit = {
    val sampleArray =Array(1,2,3,4,5,6,7,8,9,10)
    println("Array elements are:")
    sampleArray.foreach(println)                //Fetching and printing all array elements

    val secondElement = sampleArray(1)          //Fetching second element from array
    println(s"Second element from array is : $secondElement")

    val sumOfArray = sampleArray.sum            //Sum of array
    println(s"Sum of array is: $sumOfArray")
  }
}
