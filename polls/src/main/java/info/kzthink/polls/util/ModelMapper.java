package info.kzthink.polls.util;

import info.kzthink.polls.model.ChoiceResponse;
import info.kzthink.polls.model.Poll;
import info.kzthink.polls.model.User;
import info.kzthink.polls.payload.PollResponse;
import info.kzthink.polls.payload.UserSummary;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.Instant.now;

public class ModelMapper {

    public static PollResponse mapPollToPollResponse(Poll poll, Map<Long, Long> choiceVotesMap, User creator, Long userVotes) {
        PollResponse pollResponse = new PollResponse();
        pollResponse.setId(poll.getId());
        pollResponse.setQuestion(poll.getQuestion());
        pollResponse.setCreationDateTime(poll.getCreatedAt());
        pollResponse.setExpirationDateTime(poll.getExpirationDateTime());
        Instant now = now();
        pollResponse.setIsExpired(poll.getExpirationDateTime().isBefore(now()));

        List<ChoiceResponse> choiceResponses = poll.getChoices().stream().map( choice -> {
            ChoiceResponse choiceResponse = new ChoiceResponse();
            choiceResponse.setId(choice.getId());
            choiceResponse.setText(choice.getText());

            if(choiceVotesMap.containsKey(choice.getId())) {
                choiceResponse.setVoteCount(choiceVotesMap.get(choice.getId()));
            } else {
                choiceResponse.setVoteCount(0);
            }
            return choiceResponse;
        }).collect(Collectors.toList());

        pollResponse.setChoices(choiceResponses);
        UserSummary creatorSummary = new UserSummary(creator.getId(), creator.getUsername(), creator.getEmail());
        pollResponse.setCreatedBy(creatorSummary);

        if(userVotes != null){
            pollResponse.setSelectedChoice(userVotes);
        }
        long totalVotes = pollResponse.getChoices().stream().mapToLong(ChoiceResponse::getVoteCount).count();
        pollResponse.setTotalVotes(totalVotes);

        return pollResponse;
    }
}
