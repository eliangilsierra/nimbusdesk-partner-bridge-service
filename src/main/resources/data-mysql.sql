-- Demo data: room 2 (Borealis, seeded by nimbusdesk-booking-service) is blocked
-- on the partner's side for a fixed window, so hitting /availability against it
-- during that window demonstrates a "not available" response.
INSERT IGNORE INTO partner_blocks (id, room_id, blocked_from, blocked_to) VALUES
    (1, 2, '2026-01-10 09:00:00', '2026-01-10 12:00:00');
