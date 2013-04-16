/**
 * 
 */
package Systems.city;

import java.util.Random;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.IntervalEntityProcessingSystem;
import com.mythiksoftware.ProjectFrame.Logger;

import components.OnCursorComponent;
import components.WorldPositionComponent;
import components.city.ResidentialComponent;

/**
 * @author James
 *
 */
public class ResidentialSystem extends IntervalEntityProcessingSystem {
	@Mapper
	ComponentMapper<ResidentialComponent> rc;
	
	@Mapper
	ComponentMapper<OnCursorComponent> oc;
	Random rand = new Random();
	/**
	 * @param aspect
	 * @param interval
	 */
	public ResidentialSystem(float interval) {
		super(Aspect.getAspectForAll(ResidentialComponent.class), interval);
		// TODO Auto-generated constructor stub
	}
	
	 @Override
     protected void begin() {

     }
	 
	 

	/* (non-Javadoc)
	 * @see com.artemis.systems.IntervalEntityProcessingSystem#process(com.artemis.Entity)
	 */
	@Override
	protected void process(Entity e) {
		ResidentialComponent r = rc.getSafe(e);
		OnCursorComponent o = oc.getSafe(e);
		if(o != null)
			return; // skip if item is on cursor.
		if(r.Population < r.MaxPop && rand.nextInt(10) < 6){
			r.Population++;
		}
		if(rand.nextInt(10) < 2)
			r.Population--;
		Logger.Log("Residential zone reached :" + r.Population);
		
	}

}
