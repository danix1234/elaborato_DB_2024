package db2024;

import db2024.view.TopLevelManager;

public final class App {

    public static void main(String[] args) throws Throwable {
        TopLevelManager.USER.setCurrentUserEmail("d");;
        TopLevelManager.USER.show();
    }

}
