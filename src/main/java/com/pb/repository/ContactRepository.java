package com.pb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pb.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

}
