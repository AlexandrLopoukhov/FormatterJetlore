package Utils

import MessageTypes.ModifiedMessageTypes

object Utils {
  /** Create a String taged by tag from message type
    *
    *  @param inputType message type instance
    */
  def prepareStringToInstead(inputType: ModifiedMessageTypes): String = {
    return inputType.OPEN_TAG(0) + inputType.value + inputType.CLOSE_TAG
  }

  /** Create a String with value and taged part with value by tag from message type
    *
    *  @param inputType message type instance
    */
  def prepareScreenedString(inputType: ModifiedMessageTypes): String = {
    return inputType.OPEN_TAG(0)  + inputType.value + "”" + inputType.OPEN_TAG(1) + inputType.value + inputType.CLOSE_TAG
  }

}

