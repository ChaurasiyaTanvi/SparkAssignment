package ScalaAssignment

//What is method overloading in scala?Write a example in the concept for method overloading

/*Method Overloading can be defined as creation of multiple methods with same method name but different parameter data type,order and number. Method overloading is
useful if we need to perform same type of function on different inputs. */

object MethodOverloading {
  def main(args: Array[String]): Unit = {
    val intMultiple = multiplication(5,10)
    val intDoubleMultiple = multiplication(10,5.6)
    val doubleMultiple = multiplication(10.1,6.9,12.90)
    val doubleIntMultiple = multiplication(20.9,6)

    println(intMultiple)
    println(intDoubleMultiple)
    println(doubleMultiple)
    println(doubleIntMultiple)
  }

  def multiplication(num1:Int,num2:Int): Int = {
    return num1*num2
  }

  def multiplication(num1:Double,num2:Double,num3:Double): Double ={
    return num1*num2*num3
  }

  def multiplication(num1:Int,num2:Double): Double ={
    return num1*num2
  }

  def multiplication(num1:Double,num2:Int): Double ={
    return num1*num2
  }
}
