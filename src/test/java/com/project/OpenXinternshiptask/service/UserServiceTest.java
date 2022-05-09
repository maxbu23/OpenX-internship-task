package com.project.OpenXinternshiptask.service;

import com.project.OpenXinternshiptask.model.user.Address;
import com.project.OpenXinternshiptask.model.user.Geolocation;
import com.project.OpenXinternshiptask.model.user.Name;
import com.project.OpenXinternshiptask.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserServiceTest {

    private UserService underTest;

    @BeforeEach
    public void setUp(){
        RestTemplate restTemplate = new RestTemplate();
        List<User> users = generateTestData();
        underTest = new UserService(restTemplate, users);
    }

    @Test
    public void shouldGetTwoFurtherUsers(){
        // given
        List<User> expected = List.of(
                new User(1,
                        new Address(
                                new Geolocation(-90D, 87D),
                                "city2",
                                "street2",
                                2,
                                "98-765"
                        ),
                        "email2",
                        "username2",
                        "qwerty",
                        new Name("firstname2", "lastname2"),
                        "987654321",
                        0
                ),
                new User(3,
                        new Address(
                                new Geolocation(-250D,55D),
                                "city3",
                                "street3",
                                3,
                                "22-333"
                        ),
                        "email3",
                        "username3",
                        "1234abcd",
                        new Name("firstname3", "lastname3"),
                        "111222333",
                        0)

        );

        // when
        final List<User> result = underTest.getTwoFurthersUsers();
        // then
        assertThat(expected).isEqualTo(result);
    }

    @Test
    public void shouldGetUserById(){
        // given
        Integer id = 1;
        final User expected = new User(1,
                new Address(
                        new Geolocation(-90D, 87D),
                        "city2",
                        "street2",
                        2,
                        "98-765"
                ),
                "email2",
                "username2",
                "qwerty",
                new Name("firstname2", "lastname2"),
                "987654321",
                0);

        // when
        final User result = underTest.getUserById(id);

        // then
        assertThat(expected).isEqualTo(result);
    }

    private List<User> generateTestData(){
        return List.of(
                new User(
                        1,
                        new Address(
                                new Geolocation(-90D, 87D),
                                "city2",
                                "street2",
                                2,
                                "98-765"
                        ),
                        "email2",
                        "username2",
                        "qwerty",
                        new Name("firstname2", "lastname2"),
                        "987654321",
                        0),
                new User(
                        2,
                        new Address(
                                new Geolocation(-90D,87D),
                                "city2",
                                "street2",
                                2,
                                "98-765"
                        ),
                        "email2",
                        "username2",
                        "qwerty",
                        new Name("firstname2", "lastname2"),
                        "987654321",
                        0
                ),
                new User(
                        3,
                        new Address(
                                new Geolocation(-250D,55D),
                                "city3",
                                "street3",
                                3,
                                "22-333"
                        ),
                        "email3",
                        "username3",
                        "1234abcd",
                        new Name("firstname3", "lastname3"),
                        "111222333",
                        0
                )
        );
    }
}