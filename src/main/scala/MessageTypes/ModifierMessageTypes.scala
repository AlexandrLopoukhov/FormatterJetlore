package MessageTypes

trait ModifiedMessageTypes {
  val startPosition: Int
  val endPosition: Int
  val value: String
  val OPEN_TAG: List[String]
  val CLOSE_TAG: String}
