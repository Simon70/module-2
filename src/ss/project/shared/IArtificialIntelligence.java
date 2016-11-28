/**
 * 
 */
package ss.project.shared;


/**
 * @author fw
 *
 */
public interface IArtificialIntelligence {
	/**
	 * Called when the game starts.
	 */
	public void initialize();
	
	/**
	 * Called everytime the player has to place an item.
	 */
	public void doTurn();
	
	/**
	 * Called when the game ends.
	 */
	public void end();
}
