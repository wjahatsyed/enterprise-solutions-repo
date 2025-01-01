package com.shugl.dmos.repository;

import com.shugl.dmos.model.Signal;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
public interface SignalRepository extends CrudRepository<Signal, String> {
}
