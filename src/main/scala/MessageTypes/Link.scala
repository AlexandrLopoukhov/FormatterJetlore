package MessageTypes


case class Link (val startPosition: Int, val endPosition: Int, val value: String, val OPEN_TAG: List[String] = List("<a href=”", ">"), val CLOSE_TAG: String = "</a>") extends ModifiedMessageTypes

