package Utils

import MessageTypes._
import org.scalatest.FlatSpec

class UtilsTest extends FlatSpec {



  "A prepareStringToInstead" should "return prepared String to replace" in {
    assert(Utils.prepareStringToInstead(new Entity(0, 1, "test", List("<a>"), "</a>")) == "<a>test</a>")

  }

  "A prepareScreenedString for Link" should "return return screened String" in {
    assert(Utils.prepareScreenedString(new Link(0, 1, "http://bit.ly/xyz")) == "<a href=”http://bit.ly/xyz”>http://bit.ly/xyz</a>")

  }

  "A prepareScreenedString for Usename" should "return return screened String" in {
    assert(Utils.prepareScreenedString(new Username(0, 1, "elversatile")) == "<a href=”http://twitter.com/elversatile”>elversatile</a>")

  }


}
