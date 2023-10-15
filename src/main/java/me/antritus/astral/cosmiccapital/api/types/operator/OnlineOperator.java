package me.antritus.astral.cosmiccapital.api.types.operator;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.audience.MessageType;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.chat.ChatType;
import net.kyori.adventure.chat.SignedMessage;
import net.kyori.adventure.identity.Identified;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.inventory.Book;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.sound.SoundStop;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.title.TitlePart;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings({"UnstableApiUsage", "deprecation", "unused"})
public interface OnlineOperator extends Operator, Audience {
	/**
	 * Returns the real audience object for this instance.
	 * @return audience
	 */
	Audience getAudience();

	
	@Override
	@NotNull
	default Audience filterAudience(@NotNull Predicate<? super Audience> filter) {
		return getAudience().filterAudience(filter);
	}

	@Override
	default void forEachAudience(@NotNull Consumer<? super Audience> action) {
		getAudience().forEachAudience(action);
	}

	@Override
	default void sendMessage(@NotNull ComponentLike message) {
		getAudience().sendMessage(message);
	}

	@Override
	default void sendMessage(@NotNull Component message) {
		getAudience().sendMessage(message);
	}

	@Override
	default void sendMessage(@NotNull ComponentLike message, @NotNull MessageType type) {
		getAudience().sendMessage(message, type);
	}

	@Override
	default void sendMessage(@NotNull Component message, @NotNull MessageType type) {
		getAudience().sendMessage(message, type);
	}

	@Override
	default void sendMessage(@NotNull Identified source, @NotNull ComponentLike message) {
		getAudience().sendMessage(source, message);
	}

	@Override
	default void sendMessage(@NotNull Identity source, @NotNull ComponentLike message) {
		getAudience().sendMessage(source, message);
	}

	@Override
	default void sendMessage(@NotNull Identified source, @NotNull Component message) {
		getAudience().sendMessage(source, message);
	}

	@Override
	default void sendMessage(@NotNull Identity source, @NotNull Component message) {
		getAudience().sendMessage(source, message);
	}

	@Override
	default void sendMessage(@NotNull Identified source, @NotNull ComponentLike message, @NotNull MessageType type) {
		getAudience().sendMessage(source, message, type);
	}

	@Override
	default void sendMessage(@NotNull Identity source, @NotNull ComponentLike message, @NotNull MessageType type) {
		getAudience().sendMessage(source, message, type);
	}

	@Override
	default void sendMessage(@NotNull Identified source, @NotNull Component message, @NotNull MessageType type) {
		getAudience().sendMessage(source, message, type);
	}

	@Override
	default void sendMessage(@NotNull Identity source, @NotNull Component message, @NotNull MessageType type) {
		getAudience().sendMessage(source, message, type);
	}

	@Override
	default void sendMessage(@NotNull Component message, ChatType.@NotNull Bound boundChatType) {
		getAudience().sendMessage(message, boundChatType);
	}

	@Override
	default void sendMessage(@NotNull ComponentLike message, ChatType.@NotNull Bound boundChatType) {
		getAudience().sendMessage(message, boundChatType);
	}

	@Override
	default void sendMessage(@NotNull SignedMessage signedMessage, ChatType.@NotNull Bound boundChatType) {
		getAudience().sendMessage(signedMessage, boundChatType);
	}

	@Override
	default void deleteMessage(@NotNull SignedMessage signedMessage) {
		getAudience().deleteMessage(signedMessage);
	}

	@Override
	default void deleteMessage(SignedMessage.@NotNull Signature signature) {
		getAudience().deleteMessage(signature);
	}

	@Override
	default void sendActionBar(@NotNull ComponentLike message) {
		getAudience().sendActionBar(message);
	}

	@Override
	default void sendActionBar(@NotNull Component message) {
		getAudience().sendActionBar(message);
	}

	@Override
	default void sendPlayerListHeader(@NotNull ComponentLike header) {
		getAudience().sendPlayerListHeader(header);
	}

	@Override
	default void sendPlayerListHeader(@NotNull Component header) {
		getAudience().sendPlayerListHeader(header);
	}

	@Override
	default void sendPlayerListFooter(@NotNull ComponentLike footer) {
		getAudience().sendPlayerListFooter(footer);
	}

	@Override
	default void sendPlayerListFooter(@NotNull Component footer) {
		getAudience().sendPlayerListFooter(footer);
	}

	@Override
	default void sendPlayerListHeaderAndFooter(@NotNull ComponentLike header, @NotNull ComponentLike footer) {
		getAudience().sendPlayerListHeaderAndFooter(header, footer);
	}

	@Override
	default void sendPlayerListHeaderAndFooter(@NotNull Component header, @NotNull Component footer) {
		getAudience().sendPlayerListHeaderAndFooter(header, footer);
	}

	@Override
	default void showTitle(@NotNull Title title) {
		getAudience().showTitle(title);
	}

	@Override
	default <T> void sendTitlePart(@NotNull TitlePart<T> part, @NotNull T value) {
		getAudience().sendTitlePart(part, value);
	}

	@Override
	default void clearTitle() {
		getAudience().clearTitle();
	}

	@Override
	default void resetTitle() {
		getAudience().resetTitle();
	}

	@Override
	default void showBossBar(@NotNull BossBar bar) {
		getAudience().showBossBar(bar);
	}

	@Override
	default void hideBossBar(@NotNull BossBar bar) {
		getAudience().hideBossBar(bar);
	}

	@Override
	default void playSound(@NotNull Sound sound) {
		getAudience().playSound(sound);
	}

	@Override
	default void playSound(@NotNull Sound sound, double x, double y, double z) {
		getAudience().playSound(sound, x, y, z);
	}

	@Override
	default void playSound(@NotNull Sound sound, Sound.@NotNull Emitter emitter) {
		getAudience().playSound(sound, emitter);
	}

	@Override
	default void stopSound(@NotNull Sound sound) {
		getAudience().stopSound(sound);
	}

	@Override
	default void stopSound(@NotNull SoundStop stop) {
		getAudience().stopSound(stop);
	}

	@Override
	default void openBook(Book.@NotNull Builder book) {
		getAudience().openBook(book);
	}

	@Override
	default void openBook(@NotNull Book book) {
		getAudience().openBook(book);
	}
}
