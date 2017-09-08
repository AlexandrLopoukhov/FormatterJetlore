package MessageTypes


case class Entity  (val startPosition: Int, val endPosition: Int, val value: String, val OPEN_TAG: List[String] = List("<strong>"), val CLOSE_TAG: String = "</strong>") extends ModifiedMessageTypes

