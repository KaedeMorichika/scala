import scala.util.Random
import scala.math

object Main {
  def main(args: Array[String]): Unit = {
    val locationNum = 20
    var route = new Route(locationNum)
    println(route.getTotalDistance())
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
    var x = 35 + 0.0001 * i * Random.nextInt(10)
    var y = 130 + 0.0001 * i * Random.nextInt(10)
    route(i) = new Location(x, y)
  }

  def setRoute(locations: Array[Location]): Unit = {
    route = locations
  }

  def getRoute(): Array[Location] = {
    route
  }

  def getTotalDistance(): Double = {
    val distanceCalculator = new DistanceCalculator();
    var totalDistance: Double = 0

    for (i <- 0 to locationNum-2) {
      val location1 = this.getRoute()(i)
      val location2 = this.getRoute()(i+1)
      totalDistance += distanceCalculator.distanceFromLatLng(location1.getCoordinate()(0), location1.getCoordinate()(1), location2.getCoordinate()(0), location2.getCoordinate()(1))
    }

    totalDistance
  }
}

class DistanceCalculator {

  def distanceFromLatLng(lat1: Double, lng1: Double, lat2: Double, lng2: Double): Double = {

    val radLat1 = lat1 * math.Pi / 180
    val radLng1 = lng1 * math.Pi / 180
    val radLat2 = lat2 * math.Pi / 180
    val radLng2 = lat2 * math.Pi / 180

    val r = 6378.137

    val averageLat = (radLat1 - radLat2) / 2
    val averageLng = (radLng1 - radLng2) / 2

    val distance = r * 2 * math.asin(
      math.sqrt( math.pow(math.sin(averageLat), 2) + math.cos(radLat1)*math.cos(radLat2) * math.pow(math.sin(averageLng), 2) )
    )
    distance
  }

}