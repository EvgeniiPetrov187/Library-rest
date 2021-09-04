package com.petrov.service;

import com.petrov.controller.dto.BookDto;
import com.petrov.controller.dto.UserDto;
import com.petrov.persist.BookRepository;
import com.petrov.persist.UserRepository;
import com.petrov.persist.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id)
                .map(user -> new UserDto(user.getId(), user.getUsername(), user.getAge(), user.getBooksTitles()));
    }

    @Override
    public void save(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getAge(),
                userDto.getPassword()
        );
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(user.getId(), user.getUsername(), user.getAge(), user.getBooksTitles()))
                .collect(Collectors.toList());
    }

    @Override
    public void saveBook(UserDto userDto, BookDto bookDto) {
        userRepository.findById(userDto.getId()).get().getBooks()
                .add(bookRepository.findBookByTitle(bookDto.getTitle()).get());
        userRepository.save(mapUser(userDto));
    }

    @Override
    public void deleteBook(UserDto userDto, BookDto bookDto) {
        userRepository.findById(userDto.getId()).get().getBooks()
                .remove(bookRepository.findBookByTitle(bookDto.getTitle()).get());
        userRepository.save(mapUser(userDto));
    }

    public User mapUser(UserDto userDto) {
        return userRepository.getById(userDto.getId());
    }
}



