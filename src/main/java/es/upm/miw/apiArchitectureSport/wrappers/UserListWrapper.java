package es.upm.miw.apiArchitectureSport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UserListWrapper {
    List<UserWrapper> userList;

    public UserListWrapper() {
        userList = new ArrayList<>();
    }

    public List<UserWrapper> getThemeList() {
        return userList;
    }

    public void addUserWrapper(UserWrapper userWrapper) {
        userList.add(userWrapper);
    }

    public String toString(boolean justNick) {
        String result = "{\"userList\":[ ";
        for (UserWrapper userWrapper : userList) {
            result += userWrapper.toString(justNick) + ",";
        }
        return result.substring(0, result.length() - 1) + " ]}";
    }
}
