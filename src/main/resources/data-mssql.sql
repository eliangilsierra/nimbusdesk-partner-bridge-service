-- Demo data, same intent as data-mysql.sql: room 2 blocked on the partner's side.
-- Not guarded against re-insertion on restart (T-SQL's IF/BEGIN block does not
-- survive Spring's naive ";"-based script splitting) -- a small, honest reminder
-- that the SQL Server side of this adapter is not a drop-in equivalent of MySQL.
INSERT INTO PartnerBlocks (RoomId, BlockedFrom, BlockedTo) VALUES
    (2, '2026-01-10T09:00:00', '2026-01-10T12:00:00');
