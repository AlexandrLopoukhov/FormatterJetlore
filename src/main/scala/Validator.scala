import MessageTypes.ModifiedMessageTypes

object Validator {

  /** Validate answer from 1 and 2 module
    *
    *  @param inputCrawl answer from module 1
    *  @param inputTypes answer from module 2
    */
  def isInputValid(inputCrawl: String, inputTypes: List[ModifiedMessageTypes]): Boolean = {
    inputTypes.foreach(x => {
      if (inputCrawl.substring(x.startPosition, x.endPosition).replaceAll("@", "") != x.value) return false
    })
    return true
  }

}
