package binarySearchStuff;
/**
 * 
 * Main
 *
 * @author Zachery Knoebel
 *
 * This class is used to test the BinarySearchTree class
 * 
 * It creates contacts, then adds them to a binary search tree. Afterward the sorted items are printed and the tree is
 * also printed
 */
public class Main {
  public static void main(String[] args) {
    Contact[] contacts = new Contact[26];
    ContactComparator comp = new ContactComparator();
    BinarySearchTree<Contact> testTree = new BinarySearchTree<Contact>(comp);

    contacts[0] = new Contact("AAron", "Black", "1-234-567-8900");
    contacts[1] = new Contact("Barry", "HornField", "1-766-900-1234");
    contacts[2] = new Contact("Corey", "Karington", "1-678-000-2578");
    contacts[3] = new Contact("Darrel", "Waffelhausen", "1-000-333-6666");
    contacts[4] = new Contact("Ellen", "Smith", "1-857-000-5432");
    contacts[5] = new Contact("Francis", "Forello", "1-000-923-4455");
    contacts[6] = new Contact("Greg", "Moore", "1-456-111-2345");
    contacts[7] = new Contact("Hellena", "Snarl", "1-831-844-4868");
    contacts[8] = new Contact("Isabell", "Berkley", "1-987-654-1478");
    contacts[9] = new Contact("Julie", "Jensen", "1-321-654-7899");
    contacts[10] = new Contact("Kyle", "McDoogle", "1-888-335-6598");
    contacts[11] = new Contact("Lawrence", "Flemming", "0-555-985-4895");
    contacts[12] = new Contact("Mike", "Glasgo", "1-875-234-9765");
    contacts[13] = new Contact("Nedward", "Wentsworth", "1-440-563-8915");
    contacts[14] = new Contact("Oskarr", "Squinktersmith", "1-486-891-1111");
    contacts[15] = new Contact("Patricia", "Merkel", "1-483-332-5612");
    contacts[16] = new Contact("Qitra", "Sorrento", "1-878-879-9999");
    contacts[17] = new Contact("Ralph", "Flemming", "1-487-323-5689");
    contacts[18] = new Contact("Samial", "Smith", "1-857-000-4457");
    contacts[19] = new Contact("Tedward", "Wentsworth", "1-542-789-8888");
    contacts[20] = new Contact("Urdel", "Flippenstock", "1-555-666-9898");
    contacts[21] = new Contact("Valentina", "Ferrara", "1-856-489-3278");
    contacts[22] = new Contact("Waldo", "Arlington", "1-875-234-9765");
    contacts[23] = new Contact("Xeekiel", "Quint", "1-875-234-9765");
    contacts[24] = new Contact("Yannie", "Alexzandrovich", "1-842-876-2414");
    contacts[25] = new Contact("Zebadia", "Ford", "1-757-681-8645");

    for (int i = 0; i < 26; i++) {
      testTree.add(contacts[i]);
    }

    testTree.inorderString();
    testTree.printToString();
    System.out.println(testTree.maxDepth());
    
    BinarySearchTree<Contact> emptyTree = new BinarySearchTree<Contact>(comp);
    System.out.println(emptyTree.maxDepth());
    
    /**
     * set up tests for efficiency between binary search tree, bubble sort, 
     * selection sort and insertion sort
     */
    
  }
}
