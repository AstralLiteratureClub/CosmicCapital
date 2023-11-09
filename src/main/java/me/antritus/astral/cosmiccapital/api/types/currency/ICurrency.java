package me.antritus.astral.cosmiccapital.api.types.currency;

import me.antritus.astral.cosmiccapital.api.IEconomyProvider;

@SuppressWarnings("unused")
public interface ICurrency<T> {
	/**
	 * Name of the currency
	 * @return name
	 */
	String name();

	/**
	 * The plural form of this currency examples:
	 *  - currencies
	 *  - dollars
	 *  - euros
	 * @return plural
	 */
	String plural();

	/**
	 * The singular form of this currency examples:
	 *  - currency
	 *  - dollars
	 * @return singular
	 */
	String singular();
	/**
	 * The char for this currency. Examples
	 *  - $
	 *  - €
	 *  - £
	 */
	String character();

	/**
	 * The display position for this char.
	 * @see ICurrency#display(double)
	 * @return display position
	 */
	CharDisplay display();

	/**
	 * Displays given currency using given amount.
	 * @param amount amount to display
	 * @return displayed/formatted
	 */
	String display(double amount);

	/**
	 * Returns the provider for this currency.
	 * @return provider for the currency
	 */
	Class<? extends IEconomyProvider<T>> getEconomyProvider();

	IEconomyProvider<T> getProvider();

	/**
	 * Returns the char display types.
	 */
	enum CharDisplay {
		/**
		 * Never displays the character
		 */
		NEVER,
		/**
		 * Displays the character on the front
		 */
		FRONT,
		/**
		 * Displays the character on the back
		 */
		BACK
	}
}
