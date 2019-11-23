package ScalaAssignment

//How to handle exception in scala. write a program to generate null pointer exception & using finally
object ExceptionalHandling {

  def main(args: Array[String]): Unit = {
    try{
      val name:String = null
      if(name.isEmpty)
        {
          throw new NullPointerException        //Throwing null pointer exception
        }
    }
    catch {
      case exceptionCaught: NullPointerException => println("Null pointer exception caught!")     //Caught exception
    }
    finally {
      println("Finally runs!")          //Using finally
    }
  }
}
