import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val locationNum = 20;
    var route = new Route(locationNum)

    route.getRoute().foreach{ location:Location =>
      println(location.getCoordinate()(0) + ", " + location.getCoordinate()(1))
    }

  }
}

class Location(latitude: Double, longitude: Double) {

  def getCoordinate() : Array[Double] = {
    Array(latitude, longitude)
  }
}

class Route(locationNum: Int) {

  private var route = new Array[Location](locationNum)

  for (i <- 0 to locationNum-1) {
    var x = 35 + 0.01 * i * Random.nextInt(10)
    var y = 130 + 0.01 * i * Random.nextInt(10)
    route(i) = new Location(x, y)
  }

  def setRoute(locations: Array[Location]): Unit = {
    route = locations
  }

  def getRoute(): Array[Location] = {
    route
  }
}