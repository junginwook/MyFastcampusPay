package com.fastcampuspay.money.adapter.out.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataMemberMoneyRepository extends JpaRepository<MemberMoneyJpaEntity, Long> {

	@Query("SELECT e FROM MemberMoneyJpaEntity e WHERE e.membershipId = :membershipId")
	Optional<MemberMoneyJpaEntity> findUserMemberMoney(@Param("membershipId") Long membershipId);
}
