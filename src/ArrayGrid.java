/**
 * A 2D grid implemented as an array.
 * Each (x,y) coordinate can hold a single item of type <T>.
 *
 * @param <T> The type of element held in the data structure
 */
public class ArrayGrid<T> implements Grid<T> {

	private Object[][] arrayData;
	private int width;
	private int height;

	/**
	 * Constructs a new ArrayGrid object with a given width and height.
	 *
	 * @param width The width of the grid
	 * @param height The height of the grid
     * @throws IllegalArgumentException If the width or height is less than or equal to zero
	 */
	public ArrayGrid(int width, int height) throws IllegalArgumentException {
	    // TODO: implement the constructor
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Either width or height is <= 0");
		}

		this.width = width;
		this.height = height;
		arrayData = new Object[width][height];
		clear(); // just to make sure
	}

	@Override
	public void add(int x, int y, T element) throws IllegalArgumentException {
		arrayData[x][y] = element;

	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(int x, int y) throws IndexOutOfBoundsException {
        return (T)arrayData[x][y];
	}

	@Override
	public boolean remove(int x, int y) throws IndexOutOfBoundsException {
		if (arrayData[x][y] == null)
			return false;
		arrayData[x][y] = null;
		return true;
	}

	@Override
	public void clear() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				arrayData[x][y] = null;
			}
		}
	}

	@Override
	public void resize(int newWidth, int newHeight) throws IllegalArgumentException {
		Object[][] newArray = new Object[newWidth][newHeight];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (arrayData[x][y] != null) {
					if (x >= newWidth || y >= newHeight)
						throw new IllegalArgumentException("Elements lost");
					newArray[x][y] = arrayData[x][y];
				}
			}
		}
		arrayData = newArray;
	}
}