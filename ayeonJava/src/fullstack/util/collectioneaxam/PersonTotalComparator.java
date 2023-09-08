package fullstack.util.collectioneaxam;

import java.util.Comparator;

public class PersonTotalComparator implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
		return p1.total - p2.total;
	}

}
