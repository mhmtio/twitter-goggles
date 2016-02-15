package io.terrafino.twitter.goggles

import twitter4j.conf.ConfigurationBuilder
import twitter4j.Twitter
import twitter4j.TwitterFactory
import java.io.FileInputStream
import java.util.Properties

class TwitterBase {

  // twitter
  var debugEnabled = false
  var consumerKey = ""
  var consumerSecret = ""
  var accessToken = ""
  var accessTokenSecret = ""
  var twitterUsername = ""

  // email
  var emailSendTo = ""
  var emailFrom = ""
  var emailSmtpHost = ""

  def getTwitterInstance: Twitter = {
      val cb = new ConfigurationBuilder()
      cb.setDebugEnabled(debugEnabled)
          .setOAuthConsumerKey(consumerKey)
          .setOAuthConsumerSecret(consumerSecret)
          .setOAuthAccessToken(accessToken)
          .setOAuthAccessTokenSecret(accessTokenSecret)
      return new TwitterFactory(cb.build()).getInstance
  }

  def populatePropertiesFromConfigFile(propertiesFilename: String) {
      var properties = new Properties()
      properties.load(new FileInputStream(propertiesFilename))
      debugEnabled = java.lang.Boolean.parseBoolean(properties.getProperty("debug.enabled"))
      consumerKey = properties.getProperty("oauth.consumerKey")
      consumerSecret = properties.getProperty("oauth.consumerSecret")
      accessToken = properties.getProperty("oauth.accessToken")
      accessTokenSecret = properties.getProperty("oauth.accessTokenSecret")
      twitterUsername = properties.getProperty("twitter_username")
      emailSendTo = properties.getProperty("email_send_to")
      emailFrom = properties.getProperty("email_from")
      emailSmtpHost = properties.getProperty("email_smtp_host")
  }
}

