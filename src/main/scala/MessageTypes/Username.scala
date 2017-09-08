package MessageTypes


case class Username (val startPosition: Int, val endPosition: Int, val value: String, val OPEN_TAG: List[String] = List("<a href=”http://twitter.com/", ">"), val CLOSE_TAG: String = "</a>") extends ModifiedMessageTypes

