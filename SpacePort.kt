import exceptions.BrokenEngineException
import exceptions.OutOfFuelException
import exceptions.SpaceToEarthConnectionFailedException

object SpacePort
{
    fun investigateSpace(spaceCraft: SpaceCraft)
    {
        try
        {
            spaceCraft.launch()
        }
        catch (e: BrokenEngineException)
        {
            spaceCraft.sendMessageToEarth(e.localizedMessage)
            spaceCraft.repairEngine()
        }
        catch (e: OutOfFuelException)
        {
            spaceCraft.sendMessageToEarth(e.localizedMessage)
            spaceCraft.refuel()
        }
        catch (e: SpaceToEarthConnectionFailedException)
        {
            spaceCraft.sendMessageToEarth(e.localizedMessage)
            spaceCraft.fixConnection()
        }
        finally
        {
            if (spaceCraft.isInSpace)
            {
                spaceCraft.land()
            }
            else
            {
                investigateSpace(spaceCraft)
            }
        }
    }
}