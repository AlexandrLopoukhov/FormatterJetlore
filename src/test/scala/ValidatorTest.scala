import MessageTypes.{Entity, Link, ModifiedMessageTypes, Username}
import Utils.Utils
import org.scalatest.FlatSpec

class ValidatorTest extends FlatSpec {

  val testAnswer: String = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile"
  val  testMap: List[ModifiedMessageTypes] = List(new Entity(0, 5, "Obama") ,
    new Entity(14, 22, "Facebook") ,
    new Username(55, 67, "elversatile") ,
    new Link(37, 54, "http://bit.ly/xyz"))


  "A isInputValid" should "return true if input from 1 and 2 module match else false" in {
    assert(Validator.isInputValid(testAnswer, testMap) == true)

  }

}
