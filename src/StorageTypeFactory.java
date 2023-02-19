public class StorageTypeFactory {
    public static StorageType createStorageType(String userInput) {
        if(userInput.toLowerCase().equals("chest")) {
            return new Chest();
        }
        if(userInput.toLowerCase().equals("shulker")) {
            return new ShulkerBox();
        }

        return null;
    }
}
