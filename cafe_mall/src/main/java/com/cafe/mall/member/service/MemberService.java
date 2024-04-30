package com.cafe.mall.member.service;

import com.cafe.mall.member.model.Member;
import com.cafe.mall.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

	public void deleteById(Integer mbrNo){
		memberRepository.deleteById(mbrNo);
	}

	public Member save(Member member){
//		member.setCreateDt(LocalDateTime.now());
		memberRepository.save(member);
		return member;
	}

	public void updateById(Integer mbrNo, Member member){
		Optional<Member> e = memberRepository.findById(mbrNo);
		if(e.isPresent()){
			e.get().setMbrNo(member.getMbrNo());
			e.get().setId(member.getId());
			e.get().setName(member.getName());
//			e.get().setUpdateDt(LocalDateTime.now());
			memberRepository.save(member);
		}
	}

}
