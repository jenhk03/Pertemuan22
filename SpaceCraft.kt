import exceptions.BrokenEngineException
import exceptions.OutOfFuelException
import exceptions.SpaceToEarthConnectionFailedException

class SpaceCraft
{
    private var isConnectionAvailable = false
    private var isEngineInOrder = false
    private var fuel = 0
    var isInSpace = false
    fun launch()
    {
        if (fuel < 5)
        {
            throw OutOfFuelException()
        }
        if (!isEngineInOrder)
        {
            throw BrokenEngineException()
        }
        if (!isConnectionAvailable)
        {
            throw SpaceToEarthConnectionFailedException()
        }
        sendMessageToEarth("Trying to launch")
        fuel -= 5
        sendMessageToEarth("I'm in space!")
        sendMessageToEarth("I've found some extraterrestrials")
        isInSpace = true
    }
    fun refuel()
    {
        fuel += 5
        sendMessageToEarth("The fuel tank is filled")
    }
    fun repairEngine()
    {
        isEngineInOrder = true
        sendMessageToEarth("The engine is in order")
    }
    fun fixConnection()
    {
        isConnectionAvailable = true
        sendMessageToEarth("Hello Earth! Can you hear me?")
        sendMessageToEarth("Connection is established")
    }
    fun land()
    {
        sendMessageToEarth("Landing...")
        isInSpace = false
    }
    fun sendMessageToEarth(message: String)
    {
        println("Spacecraft to Earth: $message")
    }
}