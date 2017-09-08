import MessageTypes._
import Utils.Utils
import org.scalatest.FlatSpec

class FormatterTest extends FlatSpec {

  val testAnswer: String = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile"

  "A formatToHTML" should "return HTML according specification" in {

    val  testMap: List[ModifiedMessageTypes] = List(new Entity(0, 5, "Obama") ,
      new Entity(14, 22, "Facebook") ,
      new Username(55, 67, "elversatile") ,
      new Link(37, 54, "http://bit.ly/xyz"))
    val expectedResult: String = "<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=”http://bit.ly/xyz”>http://bit.ly/xyz</a> @ <a href=”http://twitter.com/elversatile”>elversatile</a>"

    assert(Formatter.formatToHTML(testAnswer, testMap) == expectedResult)
  }

  it should "throw IllegalArgumentException if we have no such type operation" in {
    case class ErrorClass  (val startPosition: Int, val endPosition: Int, val value: String, val OPEN_TAG: List[String] = List("<strong>"), val CLOSE_TAG: String = "</strong>") extends ModifiedMessageTypes
    val testMap: List[ModifiedMessageTypes] = List(new ErrorClass(0, 1, "test"))
    assertThrows[IllegalArgumentException] {
      Formatter.formatToHTML(testAnswer, testMap)
    }

  }

}
