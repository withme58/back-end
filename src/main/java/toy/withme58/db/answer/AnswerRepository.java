package toy.withme58.db.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {

    //생성 조회 삭제

    //memberId와 receiverId가 같은 것을 전체 보여주기
    //select * from answer where receiverId = ? order by id desc
    List<AnswerEntity> findAllBySenderIdOrderByIdDesc(Long receiverId);

    //answerId를 받은경우 상세 조회
    //select * from answer where answerId = ? order by id desc
    Optional<AnswerEntity> findFirstByIdAndContentIsNotNullOrderByIdDesc(Long id);

    List<AnswerEntity> findAllByReceiverId(Long receiverId);

    @Query("select a from AnswerEntity a where a.senderId = :senderId and a.content is not null")
    List<AnswerEntity> findBySenderIdAndContentIsNotNull(@Param("senderId") Long senderId);

    @Query("select a from AnswerEntity a where a.receiverId = :receiverId and a.content is not null")
    List<AnswerEntity> findByReceiverIdAndContentIsNotNull(@Param("receiverId") Long senderId);



}
