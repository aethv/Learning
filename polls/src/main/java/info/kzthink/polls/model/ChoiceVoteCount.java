package info.kzthink.polls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceVoteCount {

    private Long choiceId;
    private Long voteCount;
}
