@Service
public class SkillRequestServiceImpl implements SkillRequestService {
    private final SkillOfferRepository repository;

    public SkillRequestServiceImpl(SkillOfferRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        return repository.save(offer);
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return repository.findByUser_IdAndActiveTrue(userId);
    }
}