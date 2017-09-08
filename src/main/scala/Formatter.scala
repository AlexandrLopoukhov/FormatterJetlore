import MessageTypes._
import Utils.Utils

object Formatter {

  /** Create a String with value and taged part with value by tag from message type
    *
    *  @param inputCrawl answer from module 1
    *  @param inputTypes answer from module 1
    *  @return String taged by HTML tags
    */

  def formatToHTML(inputCrawl: String, inputTypes: List[ModifiedMessageTypes]): String = {

    var listOfContent = scala.collection.mutable.ListBuffer[String]()
    inputCrawl.replaceAll("@", "@ ").split(" ").foreach(x => listOfContent += x)


    inputTypes.foreach(x => x match {
      case entity: Entity => {
        val index = listOfContent.indexOf(entity.value)
        val newString = Utils.prepareStringToInstead(entity)
        listOfContent.map{x => if (x == entity.value) listOfContent.update(index, newString)}
      }
      case link: Link => {
        val index = listOfContent.indexOf(link.value)
        val newString = Utils.prepareScreenedString(link)
        listOfContent.map{x => if (x == link.value) listOfContent.update(index, newString)}
      }
      case username: Username => {
        val index = listOfContent.indexOf(username.value)
        val newString = Utils.prepareScreenedString(username)
        listOfContent.map{x => if (x == username.value) listOfContent.update(index, newString)}
      }
      case _ => throw new IllegalArgumentException("Unsupported operation type")
    })

    val outputString = listOfContent.reduce(_.concat(" ") + _)

    return outputString
  }

}
