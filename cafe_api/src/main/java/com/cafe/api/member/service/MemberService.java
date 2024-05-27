package com.cafe.api.member.service;

import com.cafe.api.member.model.Member;
import com.cafe.api.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> findAll() {
		List<Member> members = new ArrayList<>();
		memberRepository.findAll().forEach(e -> members.add(e));
		return members;
	}

	public Optional<Member> findById(Integer mbrNo){
		Optional<Member> member = memberRepository.findById(mbrNo);
		return member;
	}

	public List<Member> findByNm(String name) {
		final List<Member> members = memberRepository.findByName(name);
		return members.isEmpty() ? Collections.emptyList() : members;
	}

	@Transactional("transactionManager")
	public void deleteById(Integer mbrNo){
		memberRepository.deleteById(mbrNo);
	}

	@Transactional("transactionManager")
	public Member save(Member member){
		member.setCreateDt(LocalDateTime.now());
		memberRepository.save(member);
		return member;
	}

	@Transactional("transactionManager")
	public void updateById(Integer mbrNo, Member member){
		Optional<Member> e = memberRepository.findById(mbrNo);
		if(e.isPresent()){
			e.get().setMbrNo(member.getMbrNo());
			e.get().setId(member.getId());
			e.get().setName(member.getName());
			e.get().setUpdateDt(LocalDateTime.now());
			memberRepository.save(member);
		}
	}

}
