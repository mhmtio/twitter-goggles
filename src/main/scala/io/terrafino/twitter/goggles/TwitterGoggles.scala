package io.terrafino.twitter.goggles
import twitter4j.TwitterFactory
import twitter4j.Twitter
import twitter4j.conf.ConfigurationBuilder
 
object TwitterGoggles extends TwitterBase {
   
  def main(args : Array[String]) {
    
    val propertiesFile = "/Users/mha/sandbox/input/twitter.properties" 
    populatePropertiesFromConfigFile(propertiesFile)
    val twitter = getTwitterInstance

    val x = twitter.timelines().getHomeTimeline()
    val it = x.iterator()
    while (it.hasNext()) {
      println(it.next().getText())
    }
  }
}

