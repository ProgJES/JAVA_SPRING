package Hello.core.discount;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixedDiscountPolicy implements DiscountPolicy{

    private int discountFixedAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixedAmount;
        } else {
            return 0;
        }
    }
}
